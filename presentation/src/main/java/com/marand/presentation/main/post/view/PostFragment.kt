package com.marand.presentation.main.post.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.marand.presentation.AbstractFragment
import com.marand.presentation.databinding.FragmentPostBinding
import com.marand.presentation.main.post.adapter.PostAdapter
import com.marand.presentation.main.post.model.PostItemView
import com.marand.presentation.main.post.viewmodel.PostState
import com.marand.presentation.main.post.viewmodel.PostViewModel
import javax.inject.Inject

class PostFragment : AbstractFragment<FragmentPostBinding>() {
    private lateinit var postAdapter: PostAdapter
    var userId: Int = 0

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private val viewModel: PostViewModel by lazy {
        viewModelProviderFactory.create(PostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            val safeArgs = PostFragmentArgs.fromBundle(it)
            userId = safeArgs.userId
        }
    }

    override fun createViewBinding(inflater: LayoutInflater): FragmentPostBinding =
        FragmentPostBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                TODO("Not yet implemented")
                findNavController().popBackStack()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)*/

        setObservers()
    }

    private fun setObservers() {
        viewModel.stateObservable.observe(viewLifecycleOwner) {
            updateView(it)
        }
        getUserPostList()
    }

    private fun getUserPostList() {
        viewModel.getUserPostList(userId)
    }

    private fun updateView(postState: PostState) {
        when (postState) {
            PostState.Loading -> showLoading()
            is PostState.Error -> showErrorLayout(postState.message)
            is PostState.Success -> showUserPostListToUI(postState.posts)
        }
    }

    private fun showUserPostListToUI(listOfPostItemView: List<PostItemView>) {
        hideLoading()
        postAdapter = PostAdapter(listOfPostItemView)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        viewBinding.postListRv.adapter = postAdapter
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