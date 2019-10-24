//
//  ViewController.swift
//  Project5
//
//  Created by Holland Whitley on 6/20/19.
//  Copyright © 2019 Holland Whitley. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var input: UITextField!
    @IBOutlet weak var output: UITextView!
    var fileManager: FileManager = FileManager.default
    
    func listDirectory() {
        let dirPaths = fileManager.urls(for: .documentDirectory, in: .userDomainMask)
        let homePath = dirPaths[0].path
        do {
            let filelist = try fileManager.contentsOfDirectory(atPath: homePath)
            for filename in filelist {
                output.insertText(filename + "\r\n")
            }
        } catch let error {
            output.insertText("Error: \(error.localizedDescription)")
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBAction func create(_ sender: Any) {
        output.text = ""
        let dirPaths = fileManager.urls(for: .documentDirectory, in: .userDomainMask)
        if !(input.text!.isEmpty) {
            let newDir = dirPaths[0].appendingPathComponent(input.text!).path
            do {
                try fileManager.createDirectory(atPath: newDir, withIntermediateDirectories: true, attributes: nil)
            } catch let error {
                output.insertText("Error: \(error.localizedDescription)")
            }
        }
        input.text = ""
        listDirectory()
    }
    
    @IBAction func remove(_ sender: Any) {
        output.text = ""
        let dirPaths = fileManager.urls(for: .documentDirectory, in: .userDomainMask)
        if !(input.text!.isEmpty) {
            let newDir = dirPaths[0].appendingPathComponent(input.text!).path
            do {
                try fileManager.removeItem(atPath: newDir)
            } catch let error {
                output.insertText("Error: \(error.localizedDescription)")
            }
        }
        input.text = ""
        listDirectory()
    }
}

