package com.example.todayquote

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class QuoteEditAdapter (val dataList: List<Quote>)
    :RecyclerView.Adapter<QuoteEditAdapter.QuoteItemViewHolder>()
{
    class QuoteItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        lateinit var quote: Quote
        val quoteTextEdit = view.findViewById<EditText>(R.id.quote_text_edit)
        val quoteFromEdit = view.findViewById<EditText>(R.id.quote_from_edit)
        val quoteDeleteBtn = view.findViewById<Button>(R.id.quote_delete_btn)
        val quoteModifyBtn = view.findViewById<Button>(R.id.quote_modify_btn)

        init {
            val pref = view.context.getSharedPreferences("quotes", Context.MODE_PRIVATE)
            quoteDeleteBtn.setOnClickListener {
                // 삭제 관련 토스트 메시지 띄우기
                Toast.makeText(it.context, "삭제되었습니다.",Toast.LENGTH_SHORT).show()
                // EditText에 있는 내용 제거(빈 문자열로 내용 채우기)
                quoteTextEdit.setText("")
                quoteFromEdit.setText("")

                // 프리퍼런스에도 지웠음
                Quote.removeQuoteFromPreference(pref, adapterPosition)

                quote.text=""
                quote.from=""
            }
            quoteModifyBtn.setOnClickListener {
                Toast.makeText(it.context,"수정되었습니다.",Toast.LENGTH_SHORT).show()

                val newQuoteText = quoteTextEdit.text.toString()
                val newQuoteFrom = quoteTextEdit.text.toString()

                Quote.saveToPreference(pref, adapterPosition, newQuoteText, newQuoteFrom)

                quote.text = newQuoteText
                quote.from = newQuoteFrom

            }

        }

        fun bind(q: Quote) {
            quote = q
            quoteTextEdit.setText(quote.text)
            quoteFromEdit.setText(quote.from)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteItemViewHolder {
        Log.d("mytag","onCreateViewHolder")
        //LayoutInflater <=
        val view = LayoutInflater.from(parent.context)
                                .inflate(viewType, parent, false)

        return QuoteEditAdapter.QuoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteItemViewHolder, position: Int) {
        Log.d("mytag",position.toString())
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.quote_edit_list_item
    }
}