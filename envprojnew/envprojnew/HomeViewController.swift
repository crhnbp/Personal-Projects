//
//  ViewController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/13/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import UIKit

class HomeViewController: UIViewController {

    @IBAction func nextViewButtonPressed(_ sender: Any) {
        
        self.performSegue(withIdentifier: "SecondViewSegue", sender: self)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

