package com.example.people.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.people.R
import com.example.people.model.UserModel
import kotlinx.android.synthetic.main.item_layout.view.*

class UserListAdapter(val userList: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {


    fun updateUserList(newUserList: List<UserModel>) {
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.name.text = userList[position].first_name
        holder.view.email.text = userList[position].email

    }


    override fun getItemCount() = userList.size


    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}