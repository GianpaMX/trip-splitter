package io.github.gianpamx.tripsplitter.triplist

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.github.gianpamx.tripsplitter.triplist.TripListItem.Companion.LANDSCAPE

class TripListAdapter(private val context: Context) : RecyclerView.Adapter<TripListAdapter.ViewHolder>() {
    var onItemSelected: ((TripListItem) -> Unit)? = null

    private val internalListener: (Int) -> Unit = { onItemSelected?.invoke(items[it]) }

    private val items = ArrayList<TripListItem>()

    init {
        setHasStableIds(true)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].pictureOrientation
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            if (viewType == LANDSCAPE) {
                LandscapeViewHolder(context, parent, internalListener)
            } else
                PortraitViewHolder(context, parent, internalListener)

    override fun getItemId(position: Int) = items[position].id.hashCode().toLong()

    fun updateTrips(items: List<TripListItem>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(this.items, items))

        this.items.clear()
        this.items.addAll(items)

        diffResult.dispatchUpdatesTo(this)
    }

    interface OnItemSelectedListener {
        fun onItemSelected(tripListItem: TripListItem)
    }

    abstract class ViewHolder(view: View, listener: ((Int) -> Unit)?) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                listener?.invoke(adapterPosition)
            }
        }

        abstract fun bind(tripListItem: TripListItem)
    }

    class DiffCallback(val oldList: List<TripListItem>, val newList: List<TripListItem>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition].id == newList[newItemPosition].id
        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
    }
}
