package edu.quintrix.senitive.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.quintrix.senitive.R
import edu.quintrix.senitive.model.DeviceSensorModel
import java.util.ArrayList;

class DeviceSensorAdapter(val context:Context, val deviceSensorModelArrayList : ArrayList<DeviceSensorModel>) :
    RecyclerView.Adapter<DeviceSensorAdapter.Viewholder>() {

//    lateinit var context : Context
//    lateinit var deviceSensorModelArrayList : ArrayList<DeviceSensorModel>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeviceSensorAdapter.Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: DeviceSensorAdapter.Viewholder, position: Int) {
        val model : DeviceSensorModel = deviceSensorModelArrayList.get(position)
        holder.vendorText.setText(model.vendor)
        holder.nameText.setText("" + model.name)

    }

    override fun getItemCount(): Int {
        return deviceSensorModelArrayList.size
    }

    public class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon : ImageView
        val vendorText : TextView
        val nameText : TextView

        init {
            icon = itemView.findViewById(R.id.card_icon_image)
            vendorText = itemView.findViewById(R.id.vendor_name_text_view)
            nameText = itemView.findViewById(R.id.device_name_text_view)
        }

    }
}