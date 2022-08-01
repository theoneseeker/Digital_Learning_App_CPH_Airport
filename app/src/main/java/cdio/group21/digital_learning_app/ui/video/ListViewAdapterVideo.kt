package cdio.group21.digital_learning_app.ui.video

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.ui.data.Questions

class ListViewAdapterVideo(val context: Activity, val arrayList: ArrayList<Questions>): ArrayAdapter<Questions>(context,
    R.layout.list_item_questions, arrayList)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item_questions, null)

        val question : TextView = view.findViewById(R.id.tv_question)

        question.text = arrayList[position].question

        return view
    }



}