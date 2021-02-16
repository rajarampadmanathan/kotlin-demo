package com.prajaram.kotlindemo.service

import org.springframework.stereotype.Service

@Service
class GeoCoderService(){
    companion object{
        const val API_KEY="AIzaSyAhAegyfs-9g_au-bMQf-EB_R2XnoaRe6o"
        const val BASE= "https://maps.googleapis.com/maps/api/geocode/json"
    }
}

