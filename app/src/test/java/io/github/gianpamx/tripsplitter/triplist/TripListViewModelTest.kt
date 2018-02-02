package io.github.gianpamx.tripsplitter.triplist

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.github.gianpamx.tripsplitter.entity.Trip
import io.github.gianpamx.tripsplitter.triplist.Mappers.mapTripListItem
import io.github.gianpamx.tripsplitter.usecase.GetAllTripsUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class TripListViewModelTest {
    @Rule
    @JvmField
    val instantExecutor = InstantTaskExecutorRule()

    val getAllTripsUseCase = mock<GetAllTripsUseCase>()

    lateinit var tripListViewModel: TripListViewModel

    @Before
    fun setUp() {
        tripListViewModel = TripListViewModel(getAllTripsUseCase)
    }

    @Test
    fun allTrips() {
        val EXPECTED_TRIPS = createExpectedTripList()

        getCallback(getAllTripsUseCase).invoke(EXPECTED_TRIPS)

        assertEquals(EXPECTED_TRIPS.map { mapTripListItem(it) }, tripListViewModel.tripList.value)
    }

    private fun getCallback(useCase: GetAllTripsUseCase): (List<Trip>) -> Unit {
        val captor = argumentCaptor<(List<Trip>) -> Unit>()
        verify(useCase).execute(captor.capture())
        return captor.firstValue
    }

    private fun createExpectedTripList(): List<Trip> {
        val EXPECTED_TRIP_LIST = ArrayList<Trip>()
        EXPECTED_TRIP_LIST.add(Trip("ANY_ID", "ANY_STRING"))
        return EXPECTED_TRIP_LIST
    }
}
