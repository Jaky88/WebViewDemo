package com.jack.demo.webviewdemo.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jack.demo.webviewdemo.R;
import com.jack.demo.webviewdemo.cloud.bean.QuestionViewBean;
import com.jack.demo.webviewdemo.databinding.ItemFillHomeworkBinding;
import com.jack.demo.webviewdemo.view.PageRecyclerView;


import java.util.List;


/**
 * Created by li on 2017/10/13.
 */

public class FillHomeworkAdapter extends PageRecyclerView.PageAdapter {
    private String title;
    private boolean isFinished;
    private List<QuestionViewBean> questionList;
    private int taskId;

//    @Override
//    public int getRowCount() {
//        return MyApplication.getInstance().getResources().getInteger(R.integer.fill_homework_row);
//    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public int getDataCount() {
        return questionList == null ? 0 : questionList.size();
    }

    @Override
    public RecyclerView.ViewHolder onPageCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fill_homework_layout, parent, false);
        return new FillHomeworkViewHolder(view);
    }

    @Override
    public void onPageBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        QuestionViewBean questionViewBean = questionList.get(position);
        FillHomeworkViewHolder viewHolder = (FillHomeworkViewHolder) holder;
        ItemFillHomeworkBinding fillHomeworkBinding = viewHolder.getFillHomeworkBinding();
//        fillHomeworkBinding.itemHomeworkQuestion.setAnalyze(isFinished);
//        fillHomeworkBinding.itemHomeworkQuestion.setQuestionData(questionViewBean, title);
//        fillHomeworkBinding.itemHomeworkQuestion.setFinished(isFinished);
//        fillHomeworkBinding.itemHomeworkQuestion.setOnCheckAnswerListener(this);
        viewHolder.itemView.setOnClickListener(this);
        viewHolder.itemView.setTag(position);
        fillHomeworkBinding.executePendingBindings();
    }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag == null) {
            return;
        }

        int position = (int) tag;
        QuestionViewBean questionViewBean = questionList.get(position);
        if (isFinished) {
//            EventBus.getDefault().post(new ParseAnswerEvent(questionViewBean, title));
        }
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public void setData(List<QuestionViewBean> questionList, String title, int taskId) {
        this.title = title;
        this.taskId = taskId;
        this.questionList = questionList;
        notifyDataSetChanged();
    }

    public List<QuestionViewBean> getQuestionList() {
        return questionList;
    }



    public void clearData() {
        if (questionList != null && questionList.size() > 0) {
            questionList.clear();
        }
    }

    static class FillHomeworkViewHolder extends RecyclerView.ViewHolder {
        private ItemFillHomeworkBinding fillHomeworkBinding;

        public FillHomeworkViewHolder(View itemView) {
            super(itemView);
            fillHomeworkBinding = (ItemFillHomeworkBinding) DataBindingUtil.bind(itemView);
        }

        public ItemFillHomeworkBinding getFillHomeworkBinding() {
            return fillHomeworkBinding;
        }
    }
}
