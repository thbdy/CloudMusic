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
    ImageView ivLeft;
    private Context mContext;

    public CommonHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.include_toolbar_layout, this, true);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
//        headBack = (LinearLayout) view.findViewById(R.id.back_img);
//        ivLeft = view.findViewById(R.id.iv_head_left_image);
//        tvLeftText = view.findViewById(R.id.tv_left_text);
//        ivArrowDown = view.findViewById(R.id.iv_arrow_down);
//        tvRight = view.findViewById(R.id.tv_right);
//        headBack.setOnClickListener(this);
        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.CommonHeaderView);
//
        String titleText = typedArray.getString(R.styleable.CommonHeaderView_head_title);
//        boolean showArrow = typedArray.getBoolean(R.styleable.CommonHeaderView_head_title_arrow,false);
//        boolean showTextRight = typedArray.getBoolean(R.styleable.CommonHeaderView_head_text_right,false);
//        boolean showTextLeft = typedArray.getBoolean(R.styleable.CommonHeaderView_head_left_text,false);

//        if(showTextRight){
//            tvRight.setVisibility(VISIBLE);
//        }
//        if(showTextLeft){
//            tvLeftText.setVisibility(VISIBLE);
//            ivLeft.setVisibility(VISIBLE);
//        }
//
        if (TextUtils.isEmpty(titleText)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(titleText);
            tvTitle.setVisibility(View.VISIBLE);
        }
//        if(showArrow){
//            ivArrowDown.setVisibility(VISIBLE);
//        }else {
//            ivArrowDown.setVisibility(INVISIBLE);
//        }
//
//        boolean leftVisible = typedArray.getBoolean(R.styleable.CommonHeaderView_head_left_visible, true);
//        if (leftVisible) {
//            headBack.setVisibility(View.VISIBLE);
//        } else {
//            headBack.setVisibility(View.GONE);
//        }
//        typedArray.recycle();
    }


    @Override
    public void onClick(View view) {

    }

//    public interface OnLeftClickListener {
//        void leftClicked();
//    }
//
//    public interface OnRightClickListener {
//        void rightClicked();
//    }
//
//    private OnLeftClickListener leftClickListener;
//    private OnRightClickListener rightClickListener;
//
//    public void setLeftClickListener(OnLeftClickListener leftClickListener) {
//        this.leftClickListener = leftClickListener;
//    }
//

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(View.VISIBLE);
    }
//
//    /**
//     * 设置去右边文本
//     * @param title
//     */
//    public void setRightText(String title) {
//        tvRight.setText(title);
//        tvRight.setVisibility(View.VISIBLE);
//    }


}
