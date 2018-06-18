package com.example.nk.model

import javax.persistence.*


@Entity @Table(name = "bca")
data class Company(
		          @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
				  var id: Long = 0,
				  var name: String = ""
                )

