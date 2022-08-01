package cdio.group21.digital_learning_app.repository

import android.content.ContentValues.TAG
import android.util.Log
import cdio.group21.digital_learning_app.ui.data.Course
import cdio.group21.digital_learning_app.ui.data.Questions
import cdio.group21.digital_learning_app.ui.data.user
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class repository {
    private lateinit var db: FirebaseFirestore

    fun getUser(onDataChange: (userObject: user) -> Unit) : ListenerRegistration {
        db = FirebaseFirestore.getInstance()
        val doc = db.collection("user").document("123456")
        val reg = db.collection("user").addSnapshotListener(){query, exception ->
            if (query != null) {
                val docs = query.documents
                val user = docs[0].toObject(user::class.java)
                if (user != null) {
                    onDataChange(user)
                }
            }
        }
        return reg
    }

    fun getCourse(onDataChange: (courseObject: Course) -> Unit) : ListenerRegistration{
        db = FirebaseFirestore.getInstance()
        val reg = db.collection("course").addSnapshotListener(){query, exception ->
            if (query != null) {
                val docs = query.documents
                val course = docs[0].toObject(Course::class.java)
                if (course != null) {
                    onDataChange(course)
                }
            }
        }
        return reg
    }

    suspend fun deleteCourse(courseID: Int){
        db = FirebaseFirestore.getInstance()
        val user_data = hashMapOf(
            "email" to "lol@gg",
            "courses_complete" to listOf("1","2","3"),
            "courses_not_complete" to listOf("2","3"),
            "email" to "jessica@email.com",
            "jobtitle" to "Cleaner",
            "phone" to "22334455"
        )
        db.collection("user").document("123456").set(user_data)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }
}