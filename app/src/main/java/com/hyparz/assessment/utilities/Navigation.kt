package com.hyparz.assessment.utilities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hyparz.assessment.R


internal fun Fragment.navigateToDetails(args: Bundle) {
    val navController = findNavController()
    if (navController.currentDestination?.id != R.id.hyparzDetailsFragment) {
        navController.navigate(R.id.action_data_list_to_data_details,args)
    }
}