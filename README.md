# baking-soda

Baking-soda is an interface between
clojurescript's [reagent](https://github.com/reagent-project/reagent)
and [reactstrap](http://reactstrap.github.io/) (i.e., bootstrap 4 react components) or [react-bootstrap](https://react-bootstrap.github.io/) (i.e., bootstrap 3 react components).


## Usage with [Reactstrap](http://reactstrap.github.io/) (bootstrap 4)

Add the following stylesheet to your *index.html*:

```html
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
```

Put the following in the `:dependencies` vector of your *project.clj*.

```clojure
[baking-soda "0.2.0"]
[reagent "0.8.1" :exclusions [cljsjs/react
                              cljsjs/react-dom]]
[cljsjs/react "16.3.2-0"]
[cljsjs/react-dom "16.3.2-0"]
[cljsjs/react-transition-group "2.3.1-0"]
[cljsjs/react-popper "0.10.4-0"]
```

*Note: you need to use reagent 0.8+*

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
       "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."]

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

## Usage with [React-bootstrap](https://react-bootstrap.github.io/) (bootstrap 3)

Add the following stylesheet to your *index.html*:

```html
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
```

Put the following in the `:dependencies` vector of your *project.clj*

```clojure
[baking-soda "0.2.0"]
[reagent "0.7.0"]
```

*Note: you need to use reagent 0.7*

Then require baking-soda in your namespace.

```clojure
(ns foo.bar
  (:require [baking-soda.bootstrap3 :as b3]))
```

### Example

Let's take a look at a modal. In javascript, you'd write something like this:

```jsx
const Example = React.createClass({
  getInitialState() {
    return { showModal: false };
  },

  close() {
    this.setState({ showModal: false });
  },

  open() {
    this.setState({ showModal: true });
  },

  render() {
    return (
      <div>
        <p>Click to get the full Modal experience!</p>

        <Button
          bsStyle="primary"
          bsSize="large"
          onClick={this.open}
        >
          Launch demo modal
        </Button>

        <Modal show={this.state.showModal} onHide={this.close}>
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <h4>Text in a modal</h4>
            <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
          </Modal.Body>
          <Modal.Footer>
            <Button onClick={this.close}>Close</Button>
          </Modal.Footer>
        </Modal>
      </div>
    );
  }
});

ReactDOM.render(<Example />, mountNode);
```

However, in clojurescript with baking-soda, you'd write something like this:

```clojure
(ns foo.bar
  (:require
   [reagent.core :as reagent]
   [baking-soda.bootstrap3 :as b3]))
   
(defonce app-state
  (reagent/atom {:show-modal? false}))

(defn modal-open! [ratom]
  (swap! ratom assoc :show-modal? true))

(defn modal-close! [ratom]
  (swap! ratom assoc :show-modal? false))

(defn modal-example [ratom]
  (let [show-modal? (get @ratom :show-modal? false)]
    [:div
     [:p "Click to get the full Modal experience!"]
     [b3/Button {:bs-style "primary"
                :bs-size  "large"
                :on-click #(modal-open! ratom)}
      "Launch demo modal"]

     [b3/Modal {:show    show-modal?
               :on-hide #(modal-close! ratom)}
      [b3/ModalHeader {:close-button true}
       [b3/ModalTitle
        "Modal Heading"]]
      [b3/ModalBody
       [:h4 "text in a modal"]
       [:p "Duis mollis, est non commodo luctus, nisi erat porttitor ligula."]]
      [b3/ModalFooter
       [b3/Button {:on-click #(modal-close! ratom)}
        "Close"]]
      ]]))

(defn ^:export main []
  (reagent/render [modal-example app-state]
                  (.getElementById js/document "app")))
```


## Questions

If you have questions, I can usually be found hanging out in the
[clojurians](http://clojurians.net/) #reagent slack channel (my handle
is [@gadfly361](https://twitter.com/gadfly361)).

# License

Copyright © 2017 Matthew Jaoudi

Distributed under the The MIT License (MIT).
