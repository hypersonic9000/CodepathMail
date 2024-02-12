package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    // Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
    class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            // Your holder should contain a member variable for any view that will be set as you render
            // a row
            val senderTextView: TextView
            val titleTextView: TextView
            val summaryTextView: TextView

            // We also create a constructor that accepts the entire item row
            // and does the view lookups to find each sub-view
            init {
                // Stores the itemView in a public final member variable that can be used
                // to access the context from any ViewHolder instance.
                senderTextView = itemView.findViewById(R.id.senderTv)
                titleTextView = itemView.findViewById(R.id.titleTv)
                summaryTextView = itemView.findViewById(R.id.summaryTv)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val contactView = inflater.inflate(R.layout.email_item, parent, false)
            return ViewHolder(contactView)
        }

        override fun getItemCount(): Int {
            return emails.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val email = emails.get(position)
            holder.senderTextView.text = email.sender
            holder.titleTextView.text = email.title
            holder.summaryTextView.text = email.summary
        }
    }

