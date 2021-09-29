package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.ubaya.a160419009_newskoeid.model.News

class HomeListViewModel(application: Application):AndroidViewModel(application) {

    val newsLD = MutableLiveData<List<News>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        val news1 = News("28988014-2043","Cristiano Ronaldo pulang ke Manchester United, sang Kakak: Selamat Datang di Rumah","Tony June","2021/08/31",
        "MANCHESTER - Cristiano Ronaldo pulang ke Manchester United pada bursa transfer musim panas 2021. Transfer Ronaldo ke Man United pun disambut positif oleh sang kakak, Liliana Catia Aveiro.\n" +
                "\n" +
                "Dalam unggahan di instagram pribadinya, Aveiro mengucapkan selamat kepada Ronaldo yang kini telah kembali ke Old Trafford. Wanita, yang berprofesi penyanyi itu, menyebut  Man United  cocok bagi adiknya. " +
                "Selamat datang di rumah cintaku, selamat datang di tempat yang pantas untukmu. Betapa bahagia dan bangganya, terima kasih Anda telah menjadi pria hebat,” tulis Aveiro melalui akun Instagramnya (@katiaaveirooficial), Rabu (1/9/2021).\n" +
                "\n" +
                "Selain mengunggah kata-kata tersebut, wanita berusia 44 tahun itu juga mengunggah foto Ronaldo di atas takhta dengan menggunakan mahkota dan memegang trisula The Red Devils di tangannya. " +
                "Aveiro dikenal sebagai salah satu pihak yang kerap melontarkan hujatan kepada mantan klub Ronaldo sebelumnya, Juventus. Dia pun senang akhirnya sang adik dapat meninggalkan klub asal Turin tersebut.","Sports", "https://www.sportbible.com/cdn-cgi/image/width=720,quality=70,format=jpeg,fit=pad,dpr=1/https%3A%2F%2Fs3-images.sportbible.com%2Fs3%2Fcontent%2Fd1046c68612bd2a8584eb678215a94d2.png")
        val news2 = News("34578913-3865", "Demokrat: Yusril Memihak, Dapat Untung dari Politik Hina Moeldoko","Toyib Gunawan", "2021/09/17",
        "Jakarta - Partai Demokrat tidak sepakat dengan pengakuan netral advokat Yusril Ihza Mahendra terkait persoalan AD/ART Partai Demokrat yang bakal digugat ke Mahkamah Agung. Yusril justru dinilai memihak dan mendapat keuntungan dari praktik politik Moeldoko.\n" +
                "\"Yusril Ihza Mahendra mengaku netral dalam skandal pembegalan Partai Demokrat oleh Kepala Staf Kepresidenan Moeldoko. Ia mengaku menjadi kuasa hukum Moeldoko hanya karena peduli pada demokratisasi dalam tubuh partai politik,\" kata Elite Partai Demokrat, Rachland Nashidik, dalam keterangannya, Jumat (23/9/2021).\n" +
                "\n" +
                "\"Tapi skandal hina pengambil-alihan paksa Partai Demokrat oleh unsur Istana, yang pada kenyataannya dibiarkan saja oleh Presiden, pada hakikatnya adalah sebuah krisis moral politik. Dan orang yang mengambil sikap netral dalam sebuah krisis moral, sebenarnya sedang memihak pada si kuat dan si penindas,\" lanjutnya.\n" +
                "\n" +
                "Rachland lantas menyinggung Yusril yang menilai ada kekosongan hukum terkait ketiadaan otoritas negara untuk menguji kesesuaian AD/ART Partai Demokrat dengan Undang-undang. Padahal, menurut Rachland, ada partai lainnya yang bahkan memiliki kekuasaan jauh lebih besar dalam kewenangannya.\n","Politik","https://foto.wartaekonomi.co.id/files/arsip_foto_2019_06_17/yusril_ihza_mahendra_163320_big.webp")
        val news3 = News("65489756-0873", "Elon Musk Bakal Jor-joran Investasi Mobil Listrik di China","Sevilla Naufal", "2021/09/27", "JAKARTA - CEO Tesla Elon Musk berkomitmen memperluas investasinya di China. Menurutnya, China sangat penting bagi perusahaan kendaraan listriknya.\n" +
                "\n" +
                "\"Pengamatan jujur saya adalah China menghabiskan banyak sumber daya dan upaya untuk menerapkan teknologi digital terbaru di berbagai industri, termasuk industri otomotif, Tesla akan terus memperluas investasi dan upaya R&D kami di China,\" kata Musk seperti dilansir dari CNBC, Senin (27/9/2021).Beberapa waktu lalu, Musk juga sempat mengatakan dalam Kongres Kendaraan Energi Baru Dunia bahwa produsen mobil China adalah yang paling kompetitif.\n" +
                "\n" +
                "Sebelumnya, Tesla banyak menuai reputasi negatif di media. Pasalnya, perusahaan itu menghadapi sejumlah penarikan dan pengawasan seputar kasus privasi data. Dalam hal ini, Beijing pun dilaporkan telah melarang kendaraan dari Tesla oleh beberapa personel negara bagian dan personel militer.Meski begitu, Musk mengaku senang karena adanya sejumlah undang-undang yang memperkuat manajemen data.\n" +
                "\n" +
                "\"Di Tesla, kami senang melihat sejumlah undang-undang dan peraturan yang telah dirilis untuk memperkuat manajemen data,\" kata Musk.","Technology","https://asset.kompas.com/crops/RO_oivzwoUcrSHKmBK_VmKA31YM=/0x0:780x390/750x500/data/photo/2016/06/09/1316399Elon-musk780x390.jpg")
        val news4 = News("25781567-6298","Pacu Bank Digital, MNC Gandeng Amazon Web Service","Hary Himawan","2021/09/24","JAKARTA -- PT MNC Investama Tbk berkolaborasi dengan Amazon Web Services (AWS) perusahaan Amazon.com, Inc terkait penyedia cloud perusahaan. Adapun kerja sama ini untuk mendorong transformasi digital dan peningkatan pengalaman pengguna.Executive Chairman MNC Group Hary Tanoesoedibjo mengatakan pusat data lokal perusahaan perlu ditingkatkan untuk menghindari waktu pemuatan video yang lambat, atau pengalaman pemutaran yang terputus.\n" +
                "\n" +
                "\"MNC menggunakan Amazon Elastic Compute Cloud (Amazon EC2) yang menyediakan kapasitas komputasi cloud yang dapat disesuaikan agar beban kerja dapat diskalakan dan pemirsa mendapatkan tayangan yang stabil,” ujarnya saat acara Re-shaping The Future of Digital Banking Experience - MotionBanking x Amazon Web Services secara virtual, Senin (27/9).\n" +
                "\n" +
                "Menurutnya, MNC menggunakan AWS CloudFront, layanan content delivery network (CDN) untuk menyiarkan video secara global dengan kecepatan transfer tinggi, serta layanan pemrosesan dan tayangan video secara langsung untuk menyiapkan dan melindungi kualitas video selama siaran lewat internet.Sementara itu, COO MotionBanking, Teddy Tee, menambahkan cloud computing ini akan meningkatkan pelayanan terhadap nasabah seperti transaksi yang lebih cepat. Adapun penerapan layanan dari perusahaan asal AS ini akan memberikan kekuatan bagi MotionBanking bersaing di tengah masifnya layanan perbankan digital.\n" +
                "\n" +
                "\"Dengan bisa juga berkompetisi dengan juga menghadirkan produk-produk relevan dan berkualitas tanpa harus memikirkan banyak hal tentang infrastruktur hardware,\" ucapnya.\n" +
                "\n" +
                "Country Manager Amazon Web Service (AWS) Regional Indonesia Gunawan Susanto menjelaskan, kehadiran cloud computing akan memangkas waktu kerja layanan lebih cepat.\"Layanan compute dan storage lainnya bisa langsung digunakan dalam hitungan menit. Hal ini akan bisa mendrive experiment dalam suatu perusahaan,\" jelasnya.\n" +
                "\n" +
                "CTO MotionBanking Parman Suparman mengatakan MotionBanking memiliki berbagai layanan keuangan seperti rekening tabungan, transfer, pembayaran kartu kredit, dan notifikasi real-time. Perusahaan berencana membangun gudang data cloud memanfaatkan layanan analitik data AWS untuk menganalisis ratusan juta titik data konsumen secara bersamaan, seperti empat FTA TV MNC Media yang menguasai 54 persen pangsa pasar, 10 juta pelanggan DTH, televisi berbayar, dan broadband, 286 juta follower media sosial, 100 juta monthly active user (MAU) dari layanan streaming OTT dan super apps, 75 juta pembaca portal online, 2,7 juta pengguna platform e-commerce MNC Group, dan lebih banyak lagi di seluruh unit usahanya. \n" +
                "\n" +
                "“Kami telah mengubah bisnis media kami bersama AWS dan bantuan kapabilitas lanjutan yang ditawarkan AWS, termasuk analitik dan machine learning, kami berharap bisa memahami konsumen kami, memprediksi tren dan preferensi masa depan, dan menyelesaikan berbagai tantangan keuangan,” ucapnya.","Bisnis","https://awsimages.detik.net.id/visual/2018/05/21/0eb4306e-fdf2-4618-baa8-cac390774f26_43.jpeg?w=450&q=90")

        newsLD.value = arrayListOf<News>(news1,news2, news3, news4)
        loadingErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}