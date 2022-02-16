package com.github.ai.podlodka.domain.home

import com.github.ai.podlodka.data.model.CommentEntity
import com.github.ai.podlodka.data.model.HomePageEntity
import java.text.SimpleDateFormat
import java.util.Locale

class MockedHomeInteractor : HomeInteractor {

    override fun getHomePageEntity(): HomePageEntity = MOCKED_ENTITY

    companion object {

        private val DATE_FORMAT = SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH)

        val MOCKED_ENTITY = HomePageEntity(
            title = "Doka 2",
            description = "Doka 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
            reviewCount = 70_000_000,
            rating = 4.9f,
            imageUrl = "https://s3-alpha-sig.figma.com/img/284d/401f/f98fb91fbba05e15f99cdcd8e4f9d673?Expires=1646006400&Signature=OAGiVBdLRFBWxvG4UkCHI9QYZQ6UoC2Mo5nag0ZPMmDdPcCG6xKE9-TMgsHvWjfaauYmi8XSHiQyb3fRd5NXPuDWkw5ByMPqj7R97EDvFer8G9pZDXa~5rAMlPuqEggABRYR8zeOd~kKDJsvyyKeVGGUf90JyW6z7kwYZPIKmhfpard6R38-Y9ddX-xbzNTcPE5-7hRSobk3BtUMEJfz5UCKaSaQrZPpsHloNiXeAtI7RDQUuGMLWA5gMc6VFgTeZ4fl0I7K8M~qHIInOUzRbIDjl8gXFXXP0hpitPIfmX9A6vOVdxdjeel2nkQKLyv0ndeO6h3wsmec3WkB38R-0w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            iconUrl = "https://s3-alpha-sig.figma.com/img/cf52/a010/d2d8badd19c3de46d88b8a74f80aaef6?Expires=1646006400&Signature=fKjHeaX1Ssp55FE~tdNmQrq59XmTpEjLgmr~OSH-SPn0gnP0jJkFK-6o7LZgyKu-JuV8XQMuv0Z326V~-abEw5n~XYr6GxvnePE5VX8PfOcb-u-CGoQ9wB-ynjKUAGnIEeVuVkkNXLCfDFxgAbmBVIc0bhsaA78dPcZs6dsTwYyDU3DNMFeKfV1v7ZwDWbkpCX99hdbGf0lp-vMZJLZ4vImG76xWX9j~UvfH94mrYPdzbM3dtzMJxc66kUW7BCZ2TYU-SqBFs-qW9lQIBRQPh36LMbm7wMzG~N3sMRspeJrVGloeSzV2JKYGrqszoRu5IGYIUJTHl77vxVpvWsaQMg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            videos = listOf(
                "https://s3-alpha-sig.figma.com/img/2305/dbdc/a03705e66df1d47c6c658a556ae2e65e?Expires=1646006400&Signature=ULRDmqoKAmoL-Aq20EpflFHOAvYLvb1BlC6IdKFVfP~fFLADOktir32Kz38W-sFW18Y7e~jZKUKJV1bo1Cxdgp~LVRkHH7UsZcYnOP2dzLXDKXS9VYbCycDxqtQdvKN~PohPKXEMrqe--lsZ9Xq4GnUNsCe~g0bQ72TJdTxElxjjnzQGGfNnikoDT1lb38aDvCdNLEn02UopWS-Ab0pzNXdAT~ji8n6vQMdRQ1Sre8EtfDJBaUtHFgDdyUHKeAuoh-qDiyCu-rZh1o2swAYlTDCBWyQ105hfTS5gNBY8H1bkaVboIDy4OcbpR-Cjp~5-25JQTqv4rI1U3oORXw~q3w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "https://s3-alpha-sig.figma.com/img/06f5/0b27/c5f9992c70089d19417df2759454fd4a?Expires=1646006400&Signature=dyX4txd2U8qVu4BmtCzbj7KHpxBSqqLIP16aSufXBqJR4hpW0HNwZ-F68cislbJrJnFtu0-4oWlQWpyWXrBNo2U0bvpydVKC89Pbh5AIQgDZVGCir7-SOkdPBhTJOgp1N~mHn1RBWtaGjaEsW7grtqWkcT1qXRH5AlUNNBEwsnqs6Mjypd5AGBME1VxGJC1cKQnHaNGDu5jLvy5XQOlDIURpEXsYwzCtICoCotM31OdzKUvlYxCrwsnqhDFU4MJRGSZsx0QAFeUCuyiKv3rQY1n-D2pDePHFTPS59RFYWUzzVGnJVYtBWcGRe7jC0A4EUzVYw3DMamGcYCo3U7OyDw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA"
            ),
            tags = listOf(
                "MOBA",
                "MULTIPLAYER",
                "STRATEGY"
            ),
            comments = listOf(
                CommentEntity(
                    username = "Auguste Conte",
                    userImageUrl = "https://s3-alpha-sig.figma.com/img/50d7/87dc/de907b9c097cd7f9ce6f8703ed2b03f1?Expires=1646006400&Signature=CZHndBeUk9JKD~g2~bG7JNhQ5bKU289gV5~CEYDrj83KmmSH9TtI~IgGupDLfvlUcfz2bHED66DBeBzGpnYYJeTkEE5DrsxUdXO6kNCp7gG7JAxmNVFUlUlPaiAS2dxClyfLGe3ZbcGiP6CNvAr5jJHFGqtdsSUsmWM8nYR9rvRT5GfO9NeY3FDJhRL1K3OwDDOcUa08Kld0IzQJstQ2xRcudx3c0meULHxDs8jc5~BN2IIa-L19McfoCi6jaXmGqdkpOAogz2yaVa1FxXxJO6XwnRsLB6QJY9IOJRYFdYmcASXx9mY4WHNuh3WGXKt~8Gy1myecURYOxd1QF7L5Ag__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                    timestamp = parseTimestamp("2019.02.14"),
                    text = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
                ),
                CommentEntity(
                    username = "Jang Marcelino",
                    userImageUrl = "https://s3-alpha-sig.figma.com/img/6212/e251/4d28d9fa8e1c1ffdeb79b8525b209e00?Expires=1646006400&Signature=TvcGnT-2sraxbdSD2WXZ7X6CRKgkzf36IkO7wZeTjIqsvjQsNHuMCrYKkGW-2rCmbaKFQgjHMVOq1T5WzMipsa4gzH~0ykN8IWCnyyh7wXe4~iGhg3GAxs2VABgtZM7z-XfByMVKIMCwN7rHxgr66f6pkkiJbccpLtcmcY3rWBYY0oM3WzUq5m5c1BuCAaLx4SG~6-2TMXe3dAqFC4LLm9nz0~v~Vx-O0ILDaQWYahc8ecHSjZzin5r89H0hnibCkOZyCQ~0VDfh-DiJvXWcIHuD27j2BG65af5VnbBJey38nvzxj3JVVdj7uI5qyI3So4VUJYxtm~PgAaZqp2rIQQ__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                    timestamp = parseTimestamp("2019.02.14"),
                    text = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
                )
            )
        )

        private fun parseTimestamp(date: String): Long {
            return DATE_FORMAT.parse(date)?.time ?: throw IllegalStateException()
        }
    }
}