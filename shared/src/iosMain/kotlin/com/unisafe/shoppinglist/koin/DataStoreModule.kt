package com.unisafe.shoppinglist.koin

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.unisafe.shoppinglist.data.datasource.local.DATA_STORE_FILE_NAME
import com.unisafe.shoppinglist.data.datasource.local.getDataStore
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual fun getDatastoreModuleByPlatform() = module {

    single<DataStore<Preferences>> {
        getDataStore {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/$DATA_STORE_FILE_NAME"
        }
    }
}