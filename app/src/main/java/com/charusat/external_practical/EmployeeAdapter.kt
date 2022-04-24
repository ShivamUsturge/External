package com.charusat.external_practical

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item.view.*

class EmployeeAdapter(val context:Context,var arr:ArrayList<Employee>)
    : RecyclerView.Adapter<EmployeeAdapter.PersonViewHolde>()
{
    class PersonViewHolde(var view: View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Employee)
        {

            view.tvEmName.setText(p.em_name)
            view.tvEmDesig.setText(p.em_desig)
            view.tvEmSal.setText(p.em_sal.toString())

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
        var inflater= LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.card_item,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])
        holder.view.btnUpdate.setOnClickListener {
            if(context is ViewAllActivity)
            {
                context.update(position)
            }
        }
        holder.view.btnDelete.setOnClickListener {
            if(context is ViewAllActivity)
            {
                context.delete(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return  arr.size
    }
}