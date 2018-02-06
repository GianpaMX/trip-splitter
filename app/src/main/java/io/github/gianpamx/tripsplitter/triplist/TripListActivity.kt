package io.github.gianpamx.tripsplitter.triplist

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL
import dagger.android.AndroidInjection
import io.github.gianpamx.tripsplitter.R
import io.github.gianpamx.tripsplitter.trip.TripActivity
import kotlinx.android.synthetic.main.trip_list_activity.*
import javax.inject.Inject

class TripListActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: TripListViewModel

    lateinit var adapter: TripListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        setContentView(R.layout.trip_list_activity)

        adapter = TripListAdapter(this)
        adapter.onItemSelected = {
            startActivity(TripActivity.newIntent(this, it.id))
        }

        configureRecyclerView()

        viewModel.tripList.observe(this, tripListObserver)
    }

    private fun configureRecyclerView() {
        recyclerView.isDrawingCacheEnabled = true;
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(EqualGapItemDecoration(2, resources.getDimensionPixelSize(R.dimen.trip_list_grid_spacing)));
    }

    private val tripListObserver = Observer<List<TripListItem>> { it?.let { adapter.updateTrips(it) } }
}
