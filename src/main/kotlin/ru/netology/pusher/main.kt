package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Student",
          "postId": 2,
          "postAuthor": "Netology",
          "postText": "We have learned a lot in Netology! Learning is great! Come to us to unleash your learning potential and become true professional! Great opportunities are waiting for you! \nJoin us today!"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
