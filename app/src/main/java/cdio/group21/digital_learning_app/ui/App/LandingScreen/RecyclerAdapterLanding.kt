package cdio.group21.digital_learning_app.ui.App.LandingScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cdio.group21.digital_learning_app.R

class RecyclerAdapterLanding: RecyclerView.Adapter<RecyclerAdapterLanding.ViewHolder>() {

    private lateinit var mListener: onItemClickListener



    interface onItemClickListener{
        fun onItemClick(position: Int){
        }
    }

    fun setOnItemClickListen(listener: onItemClickListener){
        mListener = listener
    }
    private var titles = listOf("Runway Cleanup", "Security Training", "Team Building")

    private var completionRate = listOf("33% Completed", "50% Completed", "0% Completed")

    private var images = intArrayOf(R.drawable.runway, R.drawable.security, R.drawable.teambuilding)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterLanding.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_mandatory, parent, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterLanding.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemCompletion.text = completionRate[position]
        holder.imageBackground.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    fun setItems(){
            images = intArrayOf(R.drawable.runway, R.drawable.teambuilding)
            titles = listOf("Runway Cleanup",  "Team Building")
            completionRate = listOf("33% Completed",  "0% Completed")
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        var imageBackground: ImageView
        var itemTitle: TextView
        var itemCompletion: TextView

        init {
            imageBackground = itemView.findViewById(R.id.iv_background)
            itemTitle = itemView.findViewById(R.id.tv_title)
            itemCompletion = itemView.findViewById(R.id.tv_completion_rate)

            itemView.setOnClickListener(){

                listener.onItemClick(adapterPosition)
            }
        }
    }
}