package com.example.todayquote

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(val dataList: List<Quote>) :
        RecyclerView.Adapter<QuoteAdapter.QuoteItemViewHolder>()
{
    class QuoteItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        lateinit var quote: Quote
        val quoteText = view.findViewById<TextView>(R.id.quote_text)
        val quoteFrom = view.findViewById<TextView>(R.id.quote_from)
        val shareBtn = view.findViewById<Button>(R.id.share)

        init {
            shareBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TITLE,"힘이 되는 명언")
                intent.putExtra(Intent.EXTRA_SUBJECT,"힘이 되는 명언")
                intent.putExtra(Intent.EXTRA_TEXT,"${quote.text}\n출처 : ${quote.from}")
                intent.type = "text/plain"
                val chooser = Intent.createChooser(intent,"명언 공유")
                it.context.startActivity(chooser)
            }
        }

        fun bind(q: Quote) {
            this.quote = q
            quoteText.text = quote.text
            quoteFrom.text = quote.from
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                                .inflate(viewType, parent, false)

        return QuoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteItemViewHolder, position: Int) {
        holder.bind(dataList[position])
        // holder.view.findViewById<TextView>(R.id.quote_text).text = dataList[position].text
        // holder.view.findViewById<TextView>(R.id.quote_from).text = dataList[position].from
    }

//    override fun getItemCount(): Int {
//        return dataList.size
//    }
    override fun getItemCount() = dataList.size

//    override fun getItemViewType(position: Int): Int {
//        return R.layout.quote_list_item
//    }
    override  fun getItemViewType(position: Int) = R.layout.quote_list_item

}