package com.from206.cloudmusic.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.module.main.model.SearchHotResult;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75232 on 2019/2/21
 * Email：752323877@qq.com
 */
public class FlowLayout extends ViewGroup {
    private static final String TAG = "FlowLayout";
    private Context mContext;


    public FlowLayout(Context context) {
        this(context, null);
        mContext = context;
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        mContext = context;
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    private List<List<View>> mLineViews = new ArrayList<List<View>>();
    private List<Integer> mLineHeight = new ArrayList<Integer>();

    /**
     * 测量所有子View大小,确定ViewGroup的宽高
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //由于onMeasure会执行多次,避免重复的计算控件个数和高度,这里需要进行清空操作
        mLineViews.clear();
        mLineHeight.clear();

        //获取测量的模式和尺寸大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec)-getPaddingLeft()-getPaddingRight();
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec)+getPaddingTop()+getPaddingBottom();


        //记录ViewGroup真实的测量宽高
        int viewGroupWidth = 0-getPaddingLeft()-getPaddingRight();
        int viewGroupHeight = getPaddingTop()+getPaddingBottom();

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            viewGroupWidth = widthSize;
            viewGroupHeight = heightSize;
        } else {
            //当前所占的宽高
            int currentLineWidth = 0;
            int currentLineHeight = 0;

            //用来存储每一行上的子View
            List<View> lineView = new ArrayList<View>();
            int childViewsCount = getChildCount();
            Log.e(TAG, "onMeasure: "+childViewsCount );
            for (int i = 0; i < childViewsCount; i++) {
                View childView = getChildAt(i);
                //对子View进行测量
                measureChild(childView, widthMeasureSpec, heightMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();
                int childViewWidth = childView.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int childViewHeight = childView.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;

                if (currentLineWidth + childViewWidth > widthSize) {
                    //当前行宽+子View+左右外边距>ViewGroup的宽度,换行
                    viewGroupWidth = Math.max(currentLineWidth, widthSize);
                    viewGroupHeight += currentLineHeight;
                    //添加行高
                    mLineHeight.add(currentLineHeight);
                    //添加行对象
                    mLineViews.add(lineView);

                    //new新的一行
                    lineView = new ArrayList<View>();
                    //添加行对象里的子View
                    lineView.add(childView);
                    currentLineWidth = childViewWidth;

                } else {
                    //当前行宽+子View+左右外边距<=ViewGroup的宽度,不换行
                    currentLineWidth += childViewWidth;
                    currentLineHeight = Math.max(currentLineHeight, childViewHeight);
                    //添加行对象里的子View
                    lineView.add(childView);
                }


                if (i == childViewsCount - 1) {
                    //最后一个子View的时候
                    //添加行对象
                    mLineViews.add(lineView);
                    viewGroupWidth = Math.max(childViewWidth, viewGroupWidth);
                    viewGroupHeight += childViewHeight;
                    //添加行高
                    mLineHeight.add(currentLineHeight);

                }


            }

        }


        setMeasuredDimension(viewGroupWidth, viewGroupHeight);

    }

    /**
     * 设置ViewGroup里子View的具体位置
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left = getPaddingLeft();
        int top = getPaddingTop();
        //一共有几行
        int lines = mLineViews.size();
        for (int i = 0; i < lines; i++) {
            //每行行高
            int lineHeight = mLineHeight.get(i);
            //行内有几个子View
            List<View> viewList = mLineViews.get(i);
            int views = viewList.size();

            for (int j = 0; j < views; j++) {
                View view = viewList.get(j);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                int vl = left + marginLayoutParams.leftMargin;
                int vt = top + marginLayoutParams.topMargin;
                int vr = vl + view.getMeasuredWidth();
                int vb = vt + view.getMeasuredHeight();
                view.layout(vl, vt, vr, vb);
                left += view.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
            left = getPaddingLeft();
            top += lineHeight;

        }


    }

    /**
     * 指定ViewGroup的LayoutParams
     *
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     * 设置数据
     * @param list
     */
    public void setData(List<SearchHotResult.ResultBean.HotsBean> list){
        for(SearchHotResult.ResultBean.HotsBean bean:list){
            this.addView(createNewFlexItemTextView(bean));
        }
    }
    /**
     * 动态创建TextView
     * @return
     */
    private TextView createNewFlexItemTextView(final SearchHotResult.ResultBean.HotsBean bean) {
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setText(bean.getFirst());
        textView.setTextSize(12);
        textView.setTextColor(getResources().getColor(R.color.color333333));
        textView.setBackgroundResource(R.drawable.selector_search_hot_item_bg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFlowClickListener.onClick(bean.getFirst());
            }
        });
        int padding = DensityUtil.dp2px( 4);
        int paddingLeftAndRight = DensityUtil.dp2px( 8);
        ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, padding, paddingLeftAndRight, padding);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                DensityUtil.dp2px(26));
        int margin = DensityUtil.dp2px( 6);
        int marginTop = DensityUtil.dp2px( 16);
        layoutParams.setMargins(margin, marginTop, margin, 0);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
    public interface OnFlowClickListener{
        void onClick(String keyword);
    }

    public void setOnFlowClickListener(OnFlowClickListener onFlowClickListener) {
        this.onFlowClickListener = onFlowClickListener;
    }

    public OnFlowClickListener onFlowClickListener;


}
