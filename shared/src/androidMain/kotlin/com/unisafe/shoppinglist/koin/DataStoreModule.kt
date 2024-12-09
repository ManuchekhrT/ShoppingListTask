package com.unisafe.shoppinglist.koin

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.unisafe.shoppinglist.data.datasource.local.DATA_STORE_FILE_NAME
import com.unisafe.shoppinglist.data.datasource.local.getDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun getDatastoreModuleByPlatform() = module {

    single<DataStore<Preferences>> {
        getDataStore {
            androidContext().filesDir?.resolve(DATA_STORE_FILE_NAME)?.absolutePath
                ?: throw Exception("Couldn't get Android Datastore context.")
        }
    }
}