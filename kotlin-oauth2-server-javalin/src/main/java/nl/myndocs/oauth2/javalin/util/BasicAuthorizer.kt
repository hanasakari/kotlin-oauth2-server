package nl.myndocs.oauth2.javalin.util

import io.javalin.Context
import nl.myndocs.oauth2.authenticator.Authorizer
import nl.myndocs.oauth2.authenticator.Credentials
import nl.myndocs.oauth2.ktor.feature.util.BasicAuth

open class BasicAuthorizer : Authorizer<Context> {
    override fun extractCredentials(context: Context): Credentials? {
        val authorizationHeader = context.header("authorization") ?: ""
        return BasicAuth.parseCredentials(authorizationHeader)
    }

    override fun failedAuthentication(context: Context) {
        context.header("WWW-Authenticate", "Basic realm=\"${context.queryParam("client_id")}\"")
    }
}