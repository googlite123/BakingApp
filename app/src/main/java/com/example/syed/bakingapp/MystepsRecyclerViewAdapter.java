package com.example.syed.bakingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.syed.bakingapp.stepsFragment.OnListFragmentInteractionListener;

import java.util.List;


public class MystepsRecyclerViewAdapter extends RecyclerView.Adapter<MystepsRecyclerViewAdapter.ViewHolder> {

    private final List<Step> mValues;
    private final OnListFragmentInteractionListener mListener;
    Context context;

    public MystepsRecyclerViewAdapter(List<Step> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_steps, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Step step = mValues.get(position);
        holder.mContentView.setText(step.getShortDescription());
        holder.mIdView.setText(String.valueOf(position + 1));
        final int id = step.getID();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(id);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);

            mContentView = (TextView) view.findViewById(R.id.shortDesc);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
