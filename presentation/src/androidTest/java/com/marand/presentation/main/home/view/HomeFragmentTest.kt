package com.marand.presentation.main.home.view

import androidx.fragment.app.testing.launchFragmentInContainer
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
import com.marand.presentation.R
import com.marand.presentation.factory.user.UsersFactoryAndroidTest
import com.marand.myapplication.ui.main.MainActivity
import com.marand.myapplication.ui.main.home.adapter.UserAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeFragmentTest {

    @get:Rule
    var activityTestRule = ActivityTestRule(com.marand.myapplication.ui.main.MainActivity::class.java, false, false)

    private lateinit var userAdapter: com.marand.myapplication.ui.main.home.adapter.UserAdapter

    @Test
    fun clickUserItem_navigateToPostFragment() {
        //Arrange
        val navController = launchHomeFragment()

        setUpRecyclerView()

        //Act
        onView(withId(R.id.userListRv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        //Assert
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.postFragment)
    }

    private fun launchHomeFragment(): NavController {
        val navController = mock(NavController::class.java)
        val homeFragmentScenario = launchFragmentInContainer<com.marand.myapplication.ui.main.home.view.HomeFragment>()

        homeFragmentScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        return navController
    }

    private fun setUpRecyclerView() {
        val listOfUserItemView = UsersFactoryAndroidTest.generateListOfUserItemViews(5)

        userAdapter = com.marand.myapplication.ui.main.home.adapter.UserAdapter(listOfUserItemView)
        activityTestRule.activity.findViewById<RecyclerView>(R.id.userListRv).adapter = userAdapter
    }
}