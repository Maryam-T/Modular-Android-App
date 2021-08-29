package com.marand.myapplication.ui.main.home.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.google.common.truth.Truth.assertThat
import com.marand.myapplication.R
import com.marand.myapplication.ui.main.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@LargeTest
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    private val LIST_ITEM_POSITION_IN_TEST = 0;

    @Test
    fun clickUserItem_navigateToPostFragment() {
        //Arrange
        val navController = launchHomeFragment()

        //Act
        onView(withId(R.id.userListRv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    LIST_ITEM_POSITION_IN_TEST,
                    click()
                )
            )

        //Assert
        verify(navController).navigate(R.id.action_homeFragment_to_postFragment)
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.postFragment)
}

    /**
     * In addition to returning a new instance of our Fragment,
     * get a callback whenever the fragment’s view is created
     * or destroyed so that we can set the mock NavController
     */
    private fun launchHomeFragment(): NavController {
        val navController = mock(NavController::class.java)

        HomeFragment().also { fragment ->
            GlobalScope.launch(Dispatchers.Main) {
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        //The fragment’s view has just been created
                        navController.setGraph(R.navigation.nav_graph)
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }

        return navController
    }
}
