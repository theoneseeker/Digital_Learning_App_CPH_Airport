package cdio.group21.digital_learning_app.ui.App

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cdio.group21.digital_learning_app.R

class RecyclerAdapterAnalytics: RecyclerView.Adapter<RecyclerAdapterAnalytics.ViewHolder>() {


    private var titles = arrayOf("Runway Cleanup", "Security Training", "Team Building")

    private var images = intArrayOf(R.drawable.runway, R.drawable.security, R.drawable.teambuilding)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterAnalytics.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_analytics, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterAnalytics.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]

        holder.imageBackground.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageBackground: ImageView
        var itemTitle: TextView


        init {
            imageBackground = itemView.findViewById(R.id.iv_background)
            itemTitle = itemView.findViewById(R.id.tv_title)
        }
    }
}