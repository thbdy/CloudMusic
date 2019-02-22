package com.from206.cloudmusic.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from206.cloudmusic.R;

/**
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class CommonHeaderView extends LinearLayout implements View.OnClickListener {
    private TextView tvTitle;
    private LinearLayout headBack;
    ImageView ivArrowDown;
    TextView tvRight;
    TextView tvLeftText;
    ImageView ivBack;
    ImageView ivRight;
    private Context mContext;

    public CommonHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.include_toolbar_layout, this, true);
        tvTitle = view.findViewById(R.id.tv_title);
        ivBack = view.findViewById(R.id.iv_back);
        ivRight = view.findViewById(R.id.iv_right);
        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.CommonHeaderView);
//
        String titleText = typedArray.getString(R.styleable.CommonHeaderView_head_title);
        boolean showBack = typedArray.getBoolean(R.styleable.CommonHeaderView_head_show_back,true);
        boolean showRight = typedArray.getBoolean(R.styleable.CommonHeaderView_head_show_right,false);
//        boolean showTextRight = typedArray.getBoolean(R.styleable.CommonHeaderView_head_text_right,false);
//        boolean showTextLeft = typedArray.getBoolean(R.styleable.CommonHeaderView_head_left_text,false);

        ivBack.setVisibility(showBack?VISIBLE:INVISIBLE);
        if (TextUtils.isEmpty(titleText)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(titleText);
            tvTitle.setVisibility(View.VISIBLE);
        }
        ivRight.setVisibility(showRight?VISIBLE:INVISIBLE);
        typedArray.recycle();
    }


    @Override
    public void onClick(View view) {

    }


    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(View.VISIBLE);
    }


}
