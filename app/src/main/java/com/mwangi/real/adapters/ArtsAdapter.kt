package com.mwangi.real.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.signature.ObjectKey
import com.mwangi.real.R
import com.mwangi.real.models.Arts
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList

class ArtsAdapter(private val context: Context, private var data: MutableList<Arts>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        val imgArt: ImageView = row?.findViewById(R.id.mImgArt) as ImageView
        val btnShare: ImageView = row?.findViewById(R.id.shareIcon) as ImageView
        val txtUserDescription: TextView = row?.findViewById(R.id.User_description) as TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.art_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item: Arts = getItem(position) as Arts

        Glide.with(context)
            .load(item.imageUrl)
            .signature(ObjectKey(item.imageUrl))
            .transform(CenterCrop(), RoundedCorners(16))
            .into(viewHolder.imgArt)

        viewHolder.txtUserDescription.text = item.userDescription
        viewHolder.btnShare.setOnClickListener {
            // Create a sharing intent with the image URI
            val imageUri = Uri.parse(item.imageUrl)
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "image/jpeg"

            // Convert the image to JPEG format and create a new URI
            val outputStream = ByteArrayOutputStream()
            val inputStream = context.contentResolver.openInputStream(imageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            val jpegByteArray = outputStream.toByteArray()
            val tempFile = File(context.cacheDir, "temp.jpg")
            val fileOutputStream = FileOutputStream(tempFile)
            fileOutputStream.write(jpegByteArray)
            fileOutputStream.close()
            val tempUri = FileProvider.getUriForFile(
                context,
                context.packageName + ".provider",
                tempFile
            )
            shareIntent.putExtra(Intent.EXTRA_STREAM, tempUri)

            // Grant temporary permissions to the URI for the receiving app
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

            // Launch the sharing dialog
            val chooser = Intent.createChooser(shareIntent, "Share art using")
            chooser.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(chooser)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    fun setSearchOperation(newList: List<Arts>) {
        data.clear()
        data.addAll(newList)
        notifyDataSetChanged()
    }
}
