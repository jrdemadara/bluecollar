package org.jrdemadara.bluecollar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform