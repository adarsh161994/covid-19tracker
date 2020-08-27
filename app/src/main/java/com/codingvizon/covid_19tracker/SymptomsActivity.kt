package com.codingvizon.covid_19tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_symptoms.*


class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)


        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","having a cough that gets more severe over time"))
        symptomsList.add(Model(R.drawable.fever,"Fever","a low-grade fever that gradually increases in temperature"))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","A sore throat is a painful, dry, or scratchy feeling in the throat."))
        symptomsList.add(Model(R.drawable.fatigue,"Fatigue","feeling of tiredness or lack of energy & sleepy"))
        symptomsList.add(Model(R.drawable.infected,"Breathlessness","shortness of breath due to lung infection by COVID-19 virus."))
        symptomsList.add(Model(R.drawable.nose,"Runny Nose","cold is a viral infectious disease of the upper respiratory tract that primarily affects the nose."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter
    }
}
