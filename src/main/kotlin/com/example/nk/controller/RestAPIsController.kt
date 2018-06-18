package com.example.nk.controller

import com.example.nk.model.Company
import com.example.nk.model.DataResponse
import com.example.nk.model.DataSaveResponse
import com.example.nk.repo.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class RestAPIsController {

	@Autowired
	lateinit var companyRepository: CompanyRepository


	@GetMapping(value = "/companies")
	fun findAllCompanies(): DataResponse {
		val companies = companyRepository.findAll()
		if (companies.isEmpty()) {
			return DataResponse(false, companies.size, companies)
		} else {
			return DataResponse(true, companies.size, companies)

		}
	}



	/*Raw Data types */

	@PostMapping(value = "/save")
	fun save(@RequestBody body: Map<String, String>): DataSaveResponse {
		val id = body["id"]
		val name = body["name"]
		val ss = Company(id!!.toLong(), name!!)
		companyRepository.save(ss)


		val map = HashMap<String, String>()
		val list = ArrayList<HashMap<String, String>>()
		list.add(map)
		map.put("result", "Sucessfully data save...!")
		return DataSaveResponse(true, list)

	}


	//http://localhost:8080/api/show/99
	/*Search id for get Methoad*/
	@GetMapping(value = "/show/{id}")
    fun show(@PathVariable id:String):DataResponse {
		val companiess = companyRepository.findById(id.toLong())
		val ll = mutableListOf<Any>()
		ll.add(companiess)
		if (ll.isEmpty()) {
			return DataResponse(false, ll.size, ll)
		} else {
			return DataResponse(true, ll.size, ll)

		}
	}






}