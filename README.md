# baking-soda

baking-soda is an interface between
clojurescript's [reagent](https://github.com/reagent-project/reagent)
and [reactstrap](http://reactstrap.github.io/) (i.e., bootstrap 4 react components).

## Usage

Add the following stylesheet to your *index.html*:

```html
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
```


Put the following in the `:dependencies` vector of your *project.clj*

```clojure
[reagent "0.6.0" :exclusions [cljsjs/react]]
[cljsjs/react-with-addons "15.4.2-2"]
[cljsjs/react-dom "15.4.2-2"]
[baking-soda "0.1.1"]
```

Then require baking-soda in your namespace.

```clojure
(ns foo.bar
  (:require [baking-soda.core :as b]))
```

### Example

Let's take a look at a modal. In javascript, you'd write something like this:

```jsx
/* eslint react/no-multi-comp: 0, react/prop-types: 0 */

import React from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

class ModalExample extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      modal: false
    };

    this.toggle = this.toggle.bind(this);
  }

  toggle() {
    this.setState({
      modal: !this.state.modal
    });
  }

  render() {
    return (
      <div>
        <Button color="danger" onClick={this.toggle}>{this.props.buttonLabel}</Button>
        <Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className}>
          <ModalHeader toggle={this.toggle}>Modal title</ModalHeader>
          <ModalBody>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={this.toggle}>Do Something</Button>{' '}
            <Button color="secondary" onClick={this.toggle}>Cancel</Button>
          </ModalFooter>
        </Modal>
      </div>
    );
  }
}

export default ModalExample;
```

However, in clojurescript with baking-soda, you'd write something like this:

```clojure
(ns foo.bar
  (:require
   [reagent.core :as reagent]
   [baking-soda.core :as b]))

(defonce app-state
  (reagent/atom {:show-modal? false}))
  
(defn toggle! [ratom]
  (swap! ratom update :show-modal? not))

(defn modal-example [ratom opts]
  (let [{:keys [button-label
                class]} opts
        show-modal?     (get @ratom :show-modal? false)]
    [:div
     [b/Button {:color    "danger"
                :on-click #(toggle! ratom)}
      button-label]

     [b/Modal {:is-open show-modal?
               :toggle  #(toggle! ratom)
               :class   class}
      [b/ModalHeader
       "Modal title"]

      [b/ModalBody
       "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
	   ]

      [b/ModalFooter
       [b/Button {:color    "primary"
                  :on-click #(toggle! ratom)}
        "Do Something"]
       [b/Button {:color    "secondary"
                  :on-click #(toggle! ratom)}
        "Cancel"]]
      ]
     ]))

(defn ^:export main []
  (reagent/render [modal-example app-state {:button-label "Click Me"
                                            :class        "mymodal"}]
                  (.getElementById js/document "app")))
```

## Questions

If you have questions, I can usually be found hanging out in the
[clojurians](http://clojurians.net/) #reagent slack channel (my handle
is [@gadfly361](https://twitter.com/gadfly361)).

# License

Copyright © 2017 Matthew Jaoudi

Distributed under the The MIT License (MIT).
