package com.example.lotteryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LotteryListAdapter(val dataList: List<String>)
    :   RecyclerView.Adapter<LotteryListAdapter.ItemViewHolder>()
{
    class ItemViewHolder(val view: View)
        : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //한 항목을 표시할 레이아웃 관련 뷰를 만들어줌
        //(viewType 값이 바로 getItemViewType에서 반환한 레이아웃 리소스 식별자)
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.num).text = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.lotto_item
    }

}