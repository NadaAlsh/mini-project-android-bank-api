package com.joincoded.bankapi.data.response

data class TokenResponse(val token: String?, val balance: Double?) {
    fun getBearerToken(): String {
        return "Bearer $token"
    }
}
