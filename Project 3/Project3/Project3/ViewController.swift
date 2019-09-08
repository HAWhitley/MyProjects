//
//  ViewController.swift
//  Project3
//
//  Created by Holland Whitley on 6/17/19.
//  Copyright © 2019 Holland Whitley. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var vocab: UILabel!
    var number = 0
    var word_list : [String] = []
    var word_definition : [String] = []
    override func viewDidLoad() {
        super.viewDidLoad()
        word_list = ["Abscond", "Alacrity", "Disabuse", "Nascent", "Abyss", "Candid", "Exonerate", "Dogma", "Discern", "Opprobrium"]
        word_definition = ["to depart in a sudden and secret manner",
                           "promptness in response",
                           "to free person from deception or error",
                           "beginning to exist or develop",
                           "an extremely deep hole",
                           "impartial and honest in speech",
                           "to clear blame",
                           "a fairly held opinion",
                           "to perceive/recognize",
                           "public disgrace"]
        // Do any additional setup after loading the view.
        number = Int.random(in: 0..<10)
        vocab.text = word_list[number]
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let destination = segue.destination as! ViewController2
        
        destination.define = word_definition[number]
    }
    @IBAction func returned(segue: UIStoryboardSegue) {
        number = Int.random(in: 0..<10)
        vocab.text = word_list[number]
    }
}

