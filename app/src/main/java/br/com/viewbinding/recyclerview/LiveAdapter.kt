package br.com.viewbinding.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.viewbinding.R
import br.com.viewbinding.databinding.ResItemLiveBinding
import br.com.viewbinding.recyclerview.models.Live
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class LiveAdapter(private val onItemClicked: (Live) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LiveViewHolder(
            ResItemLiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is LiveViewHolder -> {
                holder.bind(items[position], onItemClicked)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(liveList: List<Live>) {
        this.items = liveList
    }

    class LiveViewHolder(itemView: ResItemLiveBinding) : RecyclerView.ViewHolder(itemView.root) {

        private val liveTitle = itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live: Live, onItemClicked: (Live) -> Unit) {

            liveTitle.text = live.title
            liveAuthor.text = live.author

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbnailUrl)
                .into(liveThumbnail)

            itemView.setOnClickListener {
                onItemClicked(live)
            }
        }
    }

}