package jp.shirataki.sharedelementtransition

object MountainDemoDataProvider {
    fun provideData(): List<Mountain> {
        return listOf(
            Mountain(
                name = "八ヶ岳(赤岳)",
                area = "山梨",
                description = "八ヶ岳連峰の主峰である赤岳は標高2,899mを誇り、登山者に人気の山。美しい稜線と絶景が楽しめ、初心者から上級者まで楽しめるコースが豊富。",
                imageRes = R.drawable.mountain_akadake
            ),
            Mountain(
                name = "赤城山",
                area = "群馬",
                description = "群馬県を代表する火山で、カルデラ湖の大沼を囲むように複数の峰が広がる。四季折々の景色が楽しめ、ハイキングや登山に適したコースが整備されている。",
                imageRes = R.drawable.mountain_akagi
            ),
            Mountain(
                name = "大菩薩嶺",
                area = "山梨",
                description = "標高2,057mの大菩薩嶺は富士山の眺望が素晴らしく、初心者でも比較的登りやすい山。尾根歩きが魅力で、天気が良ければ南アルプスの絶景も堪能できる。",
                imageRes = R.drawable.mountain_daibosatsurei
            ),
            Mountain(
                name = "木曽駒ケ岳",
                area = "長野",
                description = "中央アルプスの主峰で標高2,956m。ロープウェイを利用して標高を稼ぐことができ、初心者でも絶景の登山を楽しめる。千畳敷カールの美しさが魅力。",
                imageRes = R.drawable.mountain_kisokomagatake
            ),
            Mountain(
                name = "日光白根山",
                area = "栃木、群馬",
                description = "関東以北の最高峰である標高2,578mの山。火山特有の荒々しい景観と高山植物が魅力。ロープウェイを利用すれば初心者でも登頂が比較的容易。",
                imageRes = R.drawable.mountain_nikkoshirane
            ),
            Mountain(
                name = "丹沢山",
                area = "神奈川",
                description = "丹沢山地の中心に位置し、標高1,567m。関東近郊で登山を楽しめる人気の山で、山頂からの展望は良好。東京からのアクセスも良く、日帰り登山に最適。",
                imageRes = R.drawable.mountain_tanzawa
            )
        )
    }
}
