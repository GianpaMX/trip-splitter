package io.github.gianpamx.tripsplitter.trip

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.android.AndroidInjection
import io.github.gianpamx.tripsplitter.R
import kotlinx.android.synthetic.main.trip_activity.*
import javax.inject.Inject

class TripActivity : AppCompatActivity() {
    companion object {
        val TAG = "TripActivity"
        val TRIP_ID = "TRIP_ID"

        fun newIntent(context: Context, tripId: String): Intent {
            val intent = Intent(context, TripActivity::class.java)
            intent.putExtra(TRIP_ID, tripId)
            return intent
        }
    }

    @Inject
    lateinit var viewModel: TripViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        setContentView(R.layout.trip_activity)
        setSupportActionBar(toolbar)

        viewModel.loadTrip(intent.getStringExtra(TRIP_ID))

        viewModel.trip.observe(this, tripObserver)
    }

    val tripObserver = Observer<TripModel> {
        it?.let {
            supportActionBar?.title = it.name
            Glide.with(this).load(it.pictureUrl).into(backgroundSquareImageView)
        }
    }
}
