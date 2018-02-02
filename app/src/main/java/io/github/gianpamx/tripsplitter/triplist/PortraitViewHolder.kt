package io.github.gianpamx.tripsplitter.triplist

import android.content.Context
import android.graphics.Typeface.BOLD
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.format.DateFormat
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.github.gianpamx.tripsplitter.R
import kotlinx.android.synthetic.main.trip_list_item_portrait.view.*

class PortraitViewHolder(val context: Context, parent: ViewGroup?, listener: ((Int) -> Unit)?) : TripListAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.trip_list_item_portrait, parent, false), listener) {
    override fun bind(tripListItem: TripListItem) {
        Glide.with(context).load(tripListItem.pictureUrl).into(itemView.backgroundImageView)

        val builder = SpannableStringBuilder(tripListItem.name)
                .append("\n")
                .append(context.resources.getQuantityString(R.plurals.trip_list_item_box_bottom_line, tripListItem.days, DateFormat.format("MMM d, yyyy", tripListItem.startDate), tripListItem.days))

        builder.setSpan(StyleSpan(BOLD), 0, tripListItem.name.length, SPAN_EXCLUSIVE_EXCLUSIVE)

        itemView.boxTextView.text = builder
    }
}
