package com.example.footballapp.network

class HeaderDescriptor {
    val header = HashMap<String, String>()

    fun headerProvider(): Map<String,String>{
        header["Accept"] = "application/json"
        header["X-RapidAPI-Key"] = "3af0cfc0e3msh1751c32679b8f64p1f6954jsn54fb0872207f"
        return header
    }
}