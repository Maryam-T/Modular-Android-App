package com.marand.myapplication.ui.main.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.marand.myapplication.databinding.FragmentHomeBinding
import com.marand.myapplication.ui.AbstractFragment
import com.marand.presentation.main.home.model.UserItemView
import com.marand.presentation.main.home.viewmodel.UserState
import com.marand.presentation.main.home.viewmodel.UserViewModel
import javax.inject.Inject

class HomeFragment : AbstractFragment<FragmentHomeBinding>() {
    private lateinit var userAdapter: com.marand.myapplication.ui.main.home.adapter.UserAdapter

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private val viewModel: UserViewModel by viewModels {
        viewModelProviderFactory
    }

    override fun createViewBinding(inflater: LayoutInflater): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
    }

    private fun setObservers() {
        viewModel.stateObservable.observe(viewLifecycleOwner) {
            updateView(it)
        }
        getUserList()
    }

    private fun updateView(userState: UserState) {
        when (userState) {
            UserState.Loading -> showLoading()
            is UserState.Error -> showErrorLayout(userState.message)
            is UserState.Success -> showUserListToUI(userState.users)
        }
    }

    private fun getUserList() {
        viewModel.fetchUserList()
    }

    private fun showUserListToUI(listOfUserItemView: List<UserItemView>) {
        hideLoading()
        userAdapter = com.marand.myapplication.ui.main.home.adapter.UserAdapter(listOfUserItemView)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        userAdapter.onItemClickListener = { userItemView ->
            navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToPostFragment(
                    userItemView.id
                )
            )
        }
        viewBinding.userListRv.adapter = userAdapter
    }

    private fun showErrorLayout(errorMessage: String?) {
        hideLoading()
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun showLoading() {
        viewBinding.loadingTv.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        viewBinding.loadingTv.visibility = View.GONE
    }
}
