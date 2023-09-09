package base_class

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import co.th.common.utils.keyboard.KeyboardHelper
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.*
import com.karumi.dexter.listener.single.PermissionListener
import utilis.keyboard.KeyboardHelperImpl

abstract class BaseFragment<T : ViewBinding>() : Fragment() {
    protected abstract val layoutId: Int
    abstract fun updateUI(view: View, savedInstanceState: Bundle?)
    abstract fun observeViewModel()
    abstract fun listener()
    protected val loading: ProgressBar by lazy { ProgressBar(requireContext()) }
    protected val keyboardHelper: KeyboardHelper by lazy { KeyboardHelperImpl() }
    open var isCreate = false


    private lateinit var _binding: T
    val binding get() = _binding

    protected open val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        updateUI(view, savedInstanceState)
        listener()
    }



}