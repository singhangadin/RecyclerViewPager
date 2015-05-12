package com.lsjwzh.widget.recyclerviewpager;

import android.support.v7.widget.RecyclerViewEx;
import android.view.View;
import android.view.ViewGroup;

/**
 * RecyclerViewPagerAdapter </br>
 * Adapter wrapper. Use to add margin at first and last itemView.
 *
 * @author Green
 * @since 2015/1/20 下午2:17
 */
public class RecyclerViewPagerAdapter<VH extends RecyclerViewEx.ViewHolder> extends RecyclerViewEx.Adapter<VH> {
    private final RecyclerViewPager mViewPager;
    RecyclerViewEx.Adapter<VH> mAdapter;


    public RecyclerViewPagerAdapter(RecyclerViewPager viewPager, RecyclerViewEx.Adapter<VH> adapter) {
        mAdapter = adapter;
        mViewPager = viewPager;
        setHasStableIds(mAdapter.hasStableIds());
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void registerAdapterDataObserver(RecyclerViewEx.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
        mAdapter.registerAdapterDataObserver(observer);
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerViewEx.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
        mAdapter.unregisterAdapterDataObserver(observer);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        mAdapter.onBindViewHolder(holder, position);
        final View itemView = holder.itemView;
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) itemView.getLayoutParams();
        lp.width = mViewPager.getWidth() - mViewPager.getPaddingLeft() - mViewPager.getPaddingRight();
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
        mAdapter.setHasStableIds(hasStableIds);
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return mAdapter.getItemId(position);
    }
}
