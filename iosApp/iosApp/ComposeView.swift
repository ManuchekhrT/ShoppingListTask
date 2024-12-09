//
//  as.swift
//  iosApp
//
//  Created by Manuchekhr Tursunov on 09.12.2024.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        // No updates needed for this static UI
    }
}

