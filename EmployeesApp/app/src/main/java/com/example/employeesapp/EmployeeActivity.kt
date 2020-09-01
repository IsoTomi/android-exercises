package com.example.employeesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_employee.*
import kotlinx.android.synthetic.main.employee_item.*
import kotlinx.android.synthetic.main.employee_item.departmentTextView2
import kotlinx.android.synthetic.main.employee_item.emailTextView2
import kotlinx.android.synthetic.main.employee_item.nameTextView2
import kotlinx.android.synthetic.main.employee_item.phoneTextView2
import kotlinx.android.synthetic.main.employee_item.titleTextView2
import kotlinx.android.synthetic.main.employee_item.view.*
import org.json.JSONObject

class EmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        // get data from intent
        val bundle: Bundle? = intent.extras;
        if (bundle != null) {
            val employeeString = bundle!!.getString("employee")
            val employee = JSONObject(employeeString)
            val name = employee["firstName"].toString() + ' ' + employee["lastName"]
            val title = employee["title"].toString()
            val email = employee["email"].toString()
            val phone = employee["phone"].toString()
            val department = employee["department"].toString()
            val profileImage = employee["image"].toString()

            Glide.with(this).load(profileImage).into(this.profileImageView2)

            // modify here to display other employee's data too!
            this.nameTextView2.text = name
            this.titleTextView2.text = title
            this.emailTextView2.text = email
            this.phoneTextView2.text = phone
            this.departmentTextView2.text = department
        }
    }
}