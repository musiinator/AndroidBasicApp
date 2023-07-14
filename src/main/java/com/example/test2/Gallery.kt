import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Gallery(
    @SerialName("title")
    val title: String,
    @SerialName("imageUrl")
    val image: String
)
