package com.glacialware.r15k.view.views

import android.util.Log
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_test.*

/**
* Created by Guille on 06/07/2017.
*/
class TestActivity : GenericRootActivity(true) {

    // ---- Companion ----

    companion object {
        private const val TITLE_KEY = "title"
        private const val AUTHOR_KEY = "author"
        private const val TAG = "InspiringTitle"
    }

    // ---- END Companion ----

    // ---- Attributes ----

    private val mDocRef = FirebaseFirestore.getInstance().document("sampleData/inspiration")
    private val db = FirebaseFirestore.getInstance()

    // ---- END Attributes ----

    // ---- Activity ----

    override fun initFragment() {
    }

    override fun initViewModel() {
    }

    override fun initView() {
        this.setContentView(R.layout.activity_test)

        this.initMissions()
    }

    // ---- END Activity ----

    // ---- Private ----

    private fun initMissions() {
        this.db.collection("missions").get().addOnCompleteListener(this,  {
            task ->
            if (task.isSuccessful) {
                var text = ""
                val lDocuments = task.result.documents
                for (document : DocumentSnapshot in lDocuments) {
                    text += String.format("id = %s :: title = %s :: description = %s \n", document.id, document.data["title"], document.data["description"])
                }
                this.textViewTitles.text = text
            }
            else {
                Log.w(TAG, task.exception)
            }
        })
    }

    private fun initSampledata() {
        this.buttonSave.setOnClickListener { _ ->
            val titleText = this.editTextTitle.text.toString()
            val authorText = this.editTextAuthor.text.toString()
            if (!titleText.isNullOrEmpty() && !authorText.isNullOrEmpty()) {
                val dataToSave = mutableMapOf<String, Any>()
                dataToSave.put(TITLE_KEY, titleText)
                dataToSave.put(AUTHOR_KEY, authorText)
                // option 1
//                this.mDocRef.set(dataToSave as Map<String, Any>).addOnSuccessListener {
//                    Log.d(TAG, "Document has been saved!")
//                }.addOnFailureListener {
//                    error ->
//                    Log.w(TAG, "Document was not saved!", error)
//                }
                // option 2
                this.mDocRef.set(dataToSave as Map<String, Any>).addOnCompleteListener {
                    task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Hooray! Document was saved!")
                    }
                    else {
                        Log.w(TAG, "Oh no!", task.exception)
                    }
                }
            }
        }

        this.buttonFetch.setOnClickListener { _ ->
            this.mDocRef.get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val titleText = documentSnapshot.getString(TITLE_KEY)
                    val authorText = documentSnapshot.getString(AUTHOR_KEY)

                    this.textViewTitles.text = String.format("title = %s :: author = %s", titleText, authorText)
                }
            }
        }
    }

    private fun addSnapshotSampledata() {
        this.mDocRef.addSnapshotListener(this, { documentSnapshot, e ->
            if (documentSnapshot.exists()) {
                val titleText = documentSnapshot.getString(TITLE_KEY)
                val authorText = documentSnapshot.getString(AUTHOR_KEY)

                this.textViewTitles.text = String.format("title = %s :: author = %s", titleText, authorText)
            }
            else if (e != null) {
                Log.w(TAG, "Got an exception!", e)
            }
        })
    }

    // ---- END Private ----

}